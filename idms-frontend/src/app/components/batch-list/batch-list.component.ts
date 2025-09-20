import { Component, OnInit } from '@angular/core';
import { BatchService } from '../../services/batch.service';
import { Batch } from '../../models/batch.model';

@Component({
    selector: 'app-batch-list',
    templateUrl: './batch-list.component.html',
    styleUrls: ['./batch-list.component.css'],
    standalone: false
})
export class BatchListComponent implements OnInit {
  batches: Batch[] = [];

  constructor(private batchService: BatchService) {}

  ngOnInit(): void { this.load(); }
  load() { this.batchService.getAll().subscribe({ next: b => this.batches = b, error: e => console.error(e) }); }

  delete(id?: number) {
    if (!id) return;
    if (!confirm('Delete batch?')) return;
    this.batchService.delete(id).subscribe(()=>this.load());
  }
}
