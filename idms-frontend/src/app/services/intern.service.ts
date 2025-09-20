import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { InternRequest, InternResponse, IdCardType } from '../models/intern.model';

@Injectable({ providedIn: 'root' })
export class InternService {
  private base = '/api/interns';

  constructor(private http: HttpClient) {}

  create(payload: InternRequest): Observable<InternResponse> {
    return this.http.post<InternResponse>(this.base, payload);
  }

  // Simple all (if backend returns Page, change accordingly)
  getAll(): Observable<InternResponse[]> {
    // if backend returns Page, use: return this.http.get<any>(this.base).pipe(map(r => r.content))
    return this.http.get<InternResponse[]>(this.base + '?size=1000');
  }

  getById(id: number): Observable<InternResponse> {
    return this.http.get<InternResponse>(`${this.base}/${id}`);
  }

  update(id: number, payload: InternRequest): Observable<InternResponse> {
    return this.http.put<InternResponse>(`${this.base}/${id}`, payload);
  }

  delete(id: number) {
    return this.http.delete<void>(`${this.base}/${id}`);
  }

  assignBatch(internId: number, batchId: number): Observable<InternResponse> {
    return this.http.put<InternResponse>(`/api/batches/${batchId}/assign-intern/${internId}`, {});
  }

  // search with pagination (backend must support params)
  search(name?: string, type?: IdCardType, batchId?: number, page = 0, size = 10) {
    let params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    if (name) params = params.set('name', name);
    if (type) params = params.set('type', type);
    if (batchId) params = params.set('batchId', batchId.toString());
    return this.http.get<any>(this.base, { params });
  }
}
