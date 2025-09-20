import { Component, OnInit } from '@angular/core';
import { InternService } from '../../services/intern.service';
import { InternResponse } from '../../models/intern.model';

@Component({
    selector: 'app-intern-list',
    templateUrl: './intern-list.component.html',
    styleUrls: ['./intern-list.component.css'],
    standalone: false
})
export class InternListComponent implements OnInit {
  interns: InternResponse[] = [];

  constructor(private internService: InternService) {}

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.internService.getAll().subscribe({
      next: list => this.interns = list,
      error: err => console.error(err)
    });
  }

  delete(id?: number) {
    if (!id) return;
    if (!confirm('Delete this intern?')) return;
    this.internService.delete(id).subscribe(() => this.load());
  }
}
